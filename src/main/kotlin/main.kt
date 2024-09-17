
data class Likes(var count:Int)
data class  PostSource(
    val type:String,
    val platform :String,
    val data:String,
    val url :String
)
class PhotoAttachment(param:Photo) :Attachment{
    override var type:String ="photo"
    val photo =param
    override fun toString(): String {
        return "\n $photo"
    }
}

class VideoAttachment(param:Video):Attachment{
    override var type:String= "video"
    val video = param

    override fun toString(): String {
        return "\n $video"
    }
}
interface Attachment {
    val type: String
}
data class Post(
    val id:Int,//индификатор записи
    val ownerId: Int,// Идентификатор владельца стены
    val fromId: Int,//Идентификатор автора записи
    val text: String,//Текст записи
    val replyOwnerId:Int,//Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId:Int,//Идентификатор записи, в ответ на которую была оставлена текущая.
    val date : Int,// Время публикации
    val postType: String,//Тип записи
    val postSource: PostSource?,
    val attachment:Array <Attachment>? = emptyArray(),
    val canPin: Boolean,//Информация о том, может ли текущий пользователь закрепить запись
    val canDelete:Boolean,//Информация о том, может ли текущий пользователь удалить запись
    val canEdit:Boolean,//Информация о том, может ли текущий пользователь редактировать запись
    val likes: Likes =Likes(0)// лайки

)
class WallService {
    //для хранение постов внутри
    private var posts = emptyArray<Post>()
    private var lastId = 0// хранениние индификатора

    fun add(post: Post): Post {//добавляе пост на страницу
        posts += post.copy(id = ++lastId, likes = post.likes.copy())
        return posts.last()
    }

    fun update(newPost: Post): Boolean {// обновление постов
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(likes = post.likes.copy())
                return true
            }
        }
        return false
    }

    fun print() {//печать постов на экран
        for (post in posts) {
            print(post)
            print(" ")
        }
        println()
    }
}

fun main(){
    val video1 =Video(
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
    val photo1 =Photo(
        76,
        6341,
        568,
        674,
        "ujf",
        521,
        arrayOf(Sizes("size1","url",82,14)),
        156,
        466
    )
    val  attachmentVideo1 =VideoAttachment(video1)
    val attachmentPhoto1 = PhotoAttachment(photo1)
    val  likes = Likes(100)
    val posts = WallService()
    // добовляем посты
    posts.add(Post(1,
        294,
        492,
        "content",
        111224,
        23,
        1111,
        "Games",
        PostSource("das","sda","adddw","rqxd"),
        arrayOf(attachmentPhoto1,attachmentVideo1),
        true,
        true,
        true,
        likes))
    posts.add(Post(1,
        472,
        7941,
        "content",
        300222,
        542,
        455,
        "Entertainment",
        PostSource("das","sda","adddw","rqxd"),
        arrayOf(attachmentPhoto1,attachmentVideo1),
        true,
        true,
        true))
    posts.print()
    likes.count = 1
    posts.print()
    //обновляем пост который у нас есть
    println(posts.update(Post(2,
        472,
        7941,
        "content",
        300222,
        542,
        100222,
        "Music",
        PostSource("das","sda","adddw","rqxd"),
        arrayOf(attachmentPhoto1,attachmentVideo1),
        true,
        true,
        true,
        likes)))
    posts.print()
    // пытаемся обновить пост которого нет
    println(posts.update(Post(70,
        472,
        7941,
        "content",
        300222,
        6564,
        300521,
        "Entertainment",
        PostSource("das","sda","adddw","rqxd"),
        arrayOf(attachmentPhoto1,attachmentVideo1),
        true,
        true,
        true)))
    posts.print()
}