package mk.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;


import mk.test.model.AsyncResult;
import mk.test.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mk.test.model.AsyncTaskResult;

@Controller
public class AsyncController {

    protected static final Logger LOG = LoggerFactory.getLogger(AsyncController.class);
    @Autowired
    private AsyncService asyncService;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/getAsyncResults", method = RequestMethod.GET)
	@ResponseBody
	public AsyncResult getAsyncResults(){
        long startTime = System.nanoTime();
        AsyncResult asyncResult = new AsyncResult();
        List<AsyncTaskResult> asyncTaskResults = new ArrayList<AsyncTaskResult>();


        try {
            Future<AsyncTaskResult> future1 = asyncService.doSomeAsyncTask(7500L);
            Future<AsyncTaskResult> future2 = asyncService.doSomeAsyncTask(2500L);
            Future<AsyncTaskResult> future3 = asyncService.doSomeAsyncTask(1000L);
            Future<AsyncTaskResult> future4 = asyncService.doSomeAsyncTask(5000L);
            asyncTaskResults.add(future1.get());
            asyncTaskResults.add(future2.get());
            asyncTaskResults.add(future3.get());
            asyncTaskResults.add(future4.get());
            asyncResult.setAsyncTaskResults(asyncTaskResults);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        LOG.info("Total Method execution time is "+duration+ " seconds");
        asyncResult.setTotalExecutionTime(duration);
    return asyncResult;
	}
}
