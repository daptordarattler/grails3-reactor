package g3r.sample

import com.sun.xml.internal.fastinfoset.EncodingConstants
import grails.compiler.GrailsCompileStatic
import grails.converters.JSON
import grails.transaction.Transactional
import reactor.spring.context.annotation.Selector
import reactor.spring.context.annotation.Consumer

@Transactional
@Consumer
class MessageConsumerService {
    /**
     *
     * Sample format for quotes to be received from
     *
     * API Request url: http://www.iheartquotes.com/api/v1/random?format=json
     * {
         "json_class": "Fortune",
         "tags": [
             "codehappy",
             "eric_hoffer"
             ],
         "quote": "Passionate hatred can give meaning and purpose to an empty life.\r\n\t\t-- Eric Hoffer",
         "link": "http://iheartquotes.com/fortune/show/30809",
         "source": "codehappy"
        }
     *
    * */

    def latchService

    @Selector('quotes')
    def messageReceived(def eventData) {
//        println 'Getting  quote # $eventData'
//        def quoteData = [jsonClass:'',tags:[],quote:'Passionate hatred can give meaning and purpose to an empty life.\\r\\n\\t\\t-- Eric Hoffer',link:'',source:'']
        def quoteData = JSON.parse('http://www.iheartquotes.com/api/v1/random?format=json'.toURL().text)
//        println quoteData.properties
//        println 'Printing quote -------------------------------------'
        println("Quote ${eventData} : ${quoteData['quote']}");
        latchService.latch.countDown()
    }
}
