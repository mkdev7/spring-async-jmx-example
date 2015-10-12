package mk.test.service;

import mk.test.model.AsyncTaskResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {
    protected static final Logger LOG = LoggerFactory.getLogger(AsyncService.class);


    @Async
    public Future<AsyncTaskResult> doSomeAsyncTask(long milliseconds) throws InterruptedException {
        LOG.info("Doing something for  "+ milliseconds+" milliseconds" +
                " using the thread "+Thread.currentThread().getName());

        AsyncTaskResult tempAsyncTaskResult = new AsyncTaskResult();
        tempAsyncTaskResult.setMilliseconds(milliseconds);
        tempAsyncTaskResult.setThreadName(Thread.currentThread().getName());
        Thread.sleep(milliseconds);
        return new org.springframework.scheduling.annotation.AsyncResult(tempAsyncTaskResult);
    }


}

