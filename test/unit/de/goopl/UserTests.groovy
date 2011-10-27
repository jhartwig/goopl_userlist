package de.goopl

import de.goopl.gplus.User
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    void testSomething() {
        def x = [] as Set
        x<< "dresden,sdrfhdfh, berlin"
        x<< "frankfurt"
//        def yyy =(List)x.first()
        def yyy =(x as List).first()
        yyy
    }
}
