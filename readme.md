# Spring Async/JMX Console example

This example demonstrates:

 * The usage of @Async annotation in Spring
 * JMX console to display current thread usage of the application


#### @Async Annotation Configuration

* AsyncController  - The getAsyncResults in the AsyncController makes full parallel calls that run for different durations.

	Here is the sample response of the getAsyncResults method. The result includes the name of the thread that was used for the particular task and the total execution time

```json
{
    "asyncTaskResults": [{
        "milliseconds": 7500,
        "threadName": "executorService-5"
    }, {
        "milliseconds": 2500,
        "threadName": "executorService-3"
    }, {
        "milliseconds": 1000,
        "threadName": "executorService-2"
    }, {
        "milliseconds": 5000,
        "threadName": "executorService-4"
    }],
    "totalExecutionTime": 7500
}
```

* AsyncService - doSomeAsync method in AsyncService is the one that has the @Async annotation and returns a Future

* spring-mvc-async-servlet.xml  - This file has the configuration required for the @Async annotation

#### JMX Console Configuration

* ThreadPoolMBean - This is the MBean that has the attributes to display current thread usage in JMX console
* jmx-console-security-servlet.xml - This has the configuration required for setting up the JMX console
* Screenshot of the JMX Console
![alt text](https://github.com/mkdev7/spring-async-jmx-example/blob/master/src/main/webapp/resources/images/jmx_console.png "JMX console screenshot")
