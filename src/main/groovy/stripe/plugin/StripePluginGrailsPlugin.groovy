package stripe.plugin

import com.stripe.Stripe
import grails.plugins.*

class StripePluginGrailsPlugin extends Plugin {
    def version = "2.10"
    def grailsVersion = "2.4.0 > *"

    def title = "Stripe"
    def description = "Plugin for using Stripe to process credit card transactions."
    def documentation = "http://bobbywarner.github.com/grails-stripe"
    def license = "APACHE"
    def issueManagement = [ system: "GitHub", url: "https://github.com/bobbywarner/grails-stripe/issues" ]
    def scm = [ url: "https://github.com/bobbywarner/grails-stripe" ]
    def developers = [
            [ name: "Bobby Warner", email: "bobbywarner@gmail.com" ],
            [ name: "Nicholas Vaidyanathan", email: "visionary.software.solutions@gmail.com" ]
    ]

    def doWithApplicationContext = {
        Stripe.apiKey = grailsApplication.config.grails.plugins.stripe.secretKey

        if (grailsApplication.config.grails.plugins.stripe.containsKey('api')) {
            Stripe.overrideApiBase(grailsApplication.config.grails.plugins.stripe.api.url)
        }

    }
}
