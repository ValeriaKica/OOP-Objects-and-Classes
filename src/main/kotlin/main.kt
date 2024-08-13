
data class Likes(var count:Int)

data class Post(
    val id:Int,//индификатор записи
    val ownerId: Int,// Идентификатор владельца стены
    val fromId: Int,//Идентификатор автора записи
    val text: String,//Текст записи
    val replyOwnerId:Int,//Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId:Int,//Идентификатор записи, в ответ на которую была оставлена текущая.
    val date : Int,// Время публикации
    val postType: String,//Тип записи
    val canPin: Boolean,//Информация о том, может ли текущий пользователь закрепить запись
    val canDelete:Boolean,//Информация о том, может ли текущий пользователь удалить запись
    val canEdit:Boolean,//Информация о том, может ли текущий пользователь редактировать запись
    val likes: Likes =Likes(0)// лайки

)
object
WallService {
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
    val  likes = Likes(100)
    // добовляем посты
    WallService.add(Post(1,
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
        likes))
    WallService.add(Post(1,
        472,
        7941,
        "content",
        300222,
        542,
        455,
        "Entertainment",
        true,
        true,
        true))
    WallService.print()
    likes.count = 1
    WallService.print()
    //обновляем пост который у нас есть
    println(WallService.update(Post(2,
        472,
        7941,
        "content",
        300222,
        542,
        100222,
        "Music",
        true,
        true,
        true,
        likes)))
    WallService.print()
    // пытаемся обновить пост которого нет
    println(WallService.update(Post(70,
        472,
        7941,
        "content",
        300222,
        6564,
        300521,
        "Entertainment",
        true,
        true,
        true)))
    WallService.print()
}
