package failing.transaction.flush.demo

import grails.gorm.transactions.Transactional

class CommentService {

    @Transactional
    void addComments(List<String> inputs) {
        inputs.each { input ->
            Comment comment = new Comment(comment: input)
            if (comment.validate()) {
                comment.save()
            }
        }
    }

}