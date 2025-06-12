import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val newPost = Post(
            id = 1,
            authorId = 165,
            authorName = "Some Name",
            content = "Some content",
            published = 121111,
            likes = 1,
        )

        val addedPost = service.add(newPost)

        assertNotEquals(0, addedPost.id)
    }

    @Test
    fun updatePostWithExistingID() {
        val service = WallService()
        val post = service.add(
            Post(
                id = 0,
                authorId = 1,
                authorName = "Name",
                content = "content",
                published = 7,
                likes = 10,
            )
        )

        val updatedPost = post.copy(content = "New content added", likes = 115)

        assertTrue(service.update(updatedPost))
    }

    @Test
    fun updateNonExistingPost() {
        val service = WallService()
        val post = service.add(
            Post(
                id = 0,
                authorId = 1,
                authorName = "Name",
                content = "content",
                published = 10,
                likes = 7,
            )
        )

        val nonExistingPost = Post(
            id = 1_000_000,
            authorId = 33,
            authorName = "Name2",
            content = "New content",
            published = 12,
            likes = 30
        )
        assertFalse(service.update(nonExistingPost))
    }
}