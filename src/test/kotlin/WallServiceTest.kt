import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service =WallService
        val post1 = service.add(Post(
            1,
            294,
            492,
            "content",
            111224,
            23,
            111111,
            "Games",
            true,
            true,
            true,
            Likes(100)
        ))
        assertTrue(post1.id>0)
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add (Post(1,
            294,
            492,
            "content",
            111224,
            23,
            1111,
            "Games",
            true,
            true,
            true,
            Likes(100)
        ))
        service.add (Post(2,
            472,
            7941,
            "content",
            300222,
            542,
            455,
            "Entertainment",
            true,
            true,
            true,
            Likes(200)
        ))
        val update= Post(
            2,
            333,
            444,
            "content",
            35222,
            555,
            200322,
            "Music",
            true,
            true,
            true,
            Likes(400)
        )
        val result = service.update(update)
        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }
    @Test
    fun updateNotRenewal(){
        val service = WallService
        service.add (Post(1,
            294,
            492,
            "content",
            111224,
            23,
            1111,
            "Games",
            true,
            true,
            true,
            Likes(100)
        ))
        val update =Post(
            430,
            294987,
            49682,
            "content",
            111224,
            23,
            1111,
            "Games",
            true,
            true,
            true,
            Likes(100)
        )
        val result =service.update(update)
        assertFalse(result)
    }
}