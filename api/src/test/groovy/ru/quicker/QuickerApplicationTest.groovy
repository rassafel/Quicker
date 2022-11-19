package ru.quicker


import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class QuickerApplicationTest extends Specification {
    def 'Context start'() {
        expect: 'Context started'
    }
}
