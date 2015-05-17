package g3r.sample

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import grails.util.Environment
import org.springframework.boot.Banner

import static grails.util.Metadata.current as metaInfo

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        final GrailsApp app = new GrailsApp(Application)
        app.banner = new GrailsBanner()
        app.run(args)
    }
}


/**
 * Class that implements Spring Boot Banner
 * interface to show information on application startup.
 */
class GrailsBanner implements Banner {

    private static final String BANNER = '''
  ________             .__.__         ________
 /  _____/___________  |__|  |   _____\\_____  \\
/   \\  __\\_  __ \\__  \\ |  |  |  /  ___/ _(__  <
\\    \\_\\  \\  | \\// __ \\|  |  |__\\___ \\ /       \\
 \\______  /__|  (____  /__|____/____  >______  /
        \\/           \\/             \\/       \\/'''

    @Override
    void printBanner(
            org.springframework.core.env.Environment environment,
            Class<?> sourceClass,
            PrintStream out) {

        out.println BANNER

        row 'App version', metaInfo.getApplicationVersion(), out
        row 'App name', metaInfo.getApplicationName(), out
        row 'Grails version', metaInfo.getGrailsVersion(), out
        row 'Groovy version', GroovySystem.version, out
        row 'JVM version', System.getProperty('java.version'), out
        row 'Reloading active', Environment.reloadingAgentEnabled, out
        row 'Environment', Environment.current.name, out

        out.println()
    }

    private void row(final String description, final value, final PrintStream out) {
        out.print ':: '
        out.print description.padRight(16)
        out.print ' :: '
        out.println value
    }

}