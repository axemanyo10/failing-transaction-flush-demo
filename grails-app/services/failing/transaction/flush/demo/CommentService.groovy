package failing.transaction.flush.demo

import grails.gorm.transactions.Transactional

class CommentService {

    void addComments(List<String> inputs) {
        List<Comment> validComments = validCommentsFromInputs(inputs)
        saveComments(validComments)
    }

    List<Comment> validCommentsFromInputs(List<String> inputs) {
        List<Comment> validComments = []
        inputs.each { input ->
            Comment comment = new Comment(comment: input)
            if (comment.validate()) {
                validComments << comment
            }
        }
        validComments
    }

    @Transactional
    void saveComments(List<Comment> comments) {
        comments.each { comment ->
            comment.save()
        }
    }

}