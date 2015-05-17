package g3r.sample

import java.util.concurrent.atomic.AtomicInteger

class MessageProducerController {
    def latchService
    def index() {
//        notify 'quotes',params

        long start = System.currentTimeMillis();

        AtomicInteger counter = new AtomicInteger(1);

        (1..latchService.numberOfQuotes).each {
            notify("quotes", counter.getAndIncrement());
        }

        latchService.latch.await();

        long elapsed = System.currentTimeMillis()-start;

        println ''
        println '---------------------------------------------------'
        println("Elapsed time: " + elapsed + "ms");
        println("Average time per quote: " + elapsed / (Long)latchService.numberOfQuotes + "ms");

        render text:'Done loading'
    }
}
