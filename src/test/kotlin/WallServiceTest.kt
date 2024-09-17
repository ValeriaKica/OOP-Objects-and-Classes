import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val video1 = Video(
            535,
            5313,
            "fgh",
            "hji",
            5412,
            5766,
            8,
            7965,
            632485,
            85
        )
        val photo1 = Photo( 76,
            6341,
            568,
            674,
            "ujf",
            521,
            arrayOf(Sizes("size1","url",82,14)),
            156,
            466)
        val  attachmentVideo1 =VideoAttachment(video1)
        val attachmentPhoto1 = PhotoAttachment(photo1)
        val post1 = service.add(Post(
            1,
            294,
            492,
            "content",
            111224,
            23,
            111111,
            "Games",
            PostSource("das","sda","adddw","rqxd"),
            arrayOf(attachmentPhoto1, attachmentVideo1),
            true,
            true,
            true,
            Likes(100)
        ))
        assertTrue(post1.id>0)
    }

    @Test
    fun updateExisting() {
        val service = WallService()
        val video1 = Video(
            535,
            5313,
            "fgh",
            "hji",
            5412,
            5766,
            8,
            7965,
            632485,
            85
        )
        val photo1 = Photo( 76,
            6341,
            568,
            674,
            "ujf",
            521,
            arrayOf(Sizes("size1","url",82,14)),
            156,
            466)
        val  attachmentVideo1 =VideoAttachment(video1)
        val attachmentPhoto1 = PhotoAttachment(photo1)
         service.add( Post(1,
            294,
            492,
            "content",
            111224,
            23,
            1111,
            "Games",
             PostSource("das","sda","adddw","rqxd"),
             arrayOf(attachmentPhoto1, attachmentVideo1),
            true,
            true,
            true,
            Likes(100)
        ))
         service.add(Post(2,
            472,
            7941,
            "content",
            300222,
            542,
            455,
            "Entertainment",
             PostSource("das","sda","adddw","rqxd"),
             arrayOf(attachmentPhoto1, attachmentVideo1),
            true,
            true,
            true,
            Likes(200)
        ))

        val update = Post(2,
            472,
            7271,
            "Music",
            300222,
            542,
            455,
            "Entertainment",
            PostSource("das","sda","adddw","rqxd"),
            arrayOf(attachmentPhoto1, attachmentVideo1),
            true,
            true,
            true,
            Likes(200)
        )
        // проверяем результат (используйте assertTrue или assertFalse)
        val result = service.update(update)
        assertTrue(result)
    }
    @Test
    fun updateNotRenewal(){
        val service = WallService()
        val video1 = Video(
            535,
            5313,
            "fgh",
            "hji",
            5412,
            5766,
            8,
            7965,
            632485,
            85
        )
        val photo1 = Photo( 76,
            6341,
            568,
            674,
            "ujf",
            521,
            arrayOf(Sizes("size1","url",82,14)),
            156,
            466)
        val  attachmentVideo1 =VideoAttachment(video1)
        val attachmentPhoto1 = PhotoAttachment(photo1)
        service.add( Post(1,
            294,
            492,
            "content",
            111224,
            23,
            1111,
            "Games",
            PostSource("das","sda","adddw","rqxd"),
            arrayOf(attachmentPhoto1, attachmentVideo1),
            true,
            true,
            true,
            Likes(100)
        ))
        val update  = Post(
            430,
            294987,
            49682,
            "content",
            111224,
            23,
            1111,
            "Games",
            PostSource("das","sda","adddw","rqxd"),
            arrayOf(attachmentPhoto1, attachmentVideo1),
            true,
            true,
            true,
            Likes(100)
        )
        val result = service.update(update)
        assertFalse(result)
    }
}