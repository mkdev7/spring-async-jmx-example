package mk.test.model;

import java.util.List;

public class AsyncResult {
    private List<AsyncTaskResult> asyncTaskResults;

    private long totalExecutionTime;

    public List<AsyncTaskResult> getAsyncTaskResults() {
        return asyncTaskResults;
    }

    public void setAsyncTaskResults(List<AsyncTaskResult> asyncTaskResults) {
        this.asyncTaskResults = asyncTaskResults;
    }

    public long getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public void setTotalExecutionTime(long totalExecutionTime) {
        this.totalExecutionTime = totalExecutionTime;
    }
}
