package failing.transaction.flush.demo

import grails.test.hibernate.HibernateSpec
import grails.testing.services.ServiceUnitTest

class CommentServiceSpec extends HibernateSpec implements ServiceUnitTest<CommentService> {

    List domainClasses = [Comment]

    void 'test comments are saved'() {
        given:
        List<String> comments = ['valid comment', 'this comment is too long', 'too short', 'blah blah blah']
        when:
        service.addComments(comments)
        then: 'comments "valid comment" and "blah blah blah" should have been saved'
        Comment.count == 2
    }
}