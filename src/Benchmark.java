import java.util.List;
import java.util.function.Supplier;

public class Benchmark{

    public static final int RUNS = 5;

    // ── Result record ────────────────────────────────────────────────────────

    public static class Result {
        public final long avgTimeNs;
        public final long avgMemBytes;
        public final List<Integer> path;        // path from the first run

        Result(long avgTimeNs, long avgMemBytes, List<Integer> path) {
            this.avgTimeNs = avgTimeNs;
            this.avgMemBytes = avgMemBytes;
            this.path = path;
        }
    }

    public static Result run(Supplier<List<Integer>> searchFn) {
        long totalTime = 0;
        long totalMem = 0;
        List<Integer> firstPath = null;

        for (int i = 0; i < RUNS; i++) {
            System.gc();
            Runtime rt = Runtime.getRuntime();
            long memBefore = rt.totalMemory() - rt.freeMemory();
            long t0 = System.nanoTime();

            List<Integer> path = searchFn.get();

            long t1 = System.nanoTime();
            long memAfter = rt.totalMemory() - rt.freeMemory();

            totalTime += (t1 - t0);
            totalMem += Math.max(0, memAfter - memBefore);
            if (firstPath == null) firstPath = path;
        }

        return new Result(totalTime / RUNS, totalMem / RUNS, firstPath);
    }
}