import g3r.sample.MyLatchImpl

import java.util.concurrent.CountDownLatch

// Place your Spring DSL code here
beans = {
    latchService(MyLatchImpl){
        numberOfQuotes = 20
        latch = new CountDownLatch(numberOfQuotes)
    }
}
