package failing.transaction.flush.demo

class Comment {

    String comment

    static constraints = {
        comment size: 10..20
    }

    static mapping = {
        id generator: 'sequence'
    }
}