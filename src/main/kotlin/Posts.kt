data class Post(
    var id: Int,
    val authorId: Int,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val date: Int = 0,
    val isFavourite: Boolean = false,
    val authorName: String,
    val content: String,
    val published: Long,
    val likes: Int,
    val signerId: Int = 0,
    val canPin: Boolean = false,
    val comments: Comments? = null,
    val copyright: Copyright? = null
) {

    class Comments(count: Int, canPost: Boolean, groupsCanPost: Boolean, canClose: Boolean, canOpen: Boolean)

    class Copyright(id: Int, link: String, name: String, type: String)

}

class WallService {

    private var posts = emptyArray<Post>()
    private var uniqueId = 0

    fun add(post: Post): Post {
        uniqueId += 1
        val newPost = post.copy(id = uniqueId)
        posts += newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun likeById(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes + 1)
            }
        }
    }
}

fun main() {
    val post = Post(1, 1, authorName = "author", content = "content", likes = 0, published = 0)
    val liked = post.copy(likes = post.likes + 1)
    val (id, authorId, _, _, _, _, _, _, _, _, content) = post
    println(liked)
    println("$id, $authorId, $content")
}