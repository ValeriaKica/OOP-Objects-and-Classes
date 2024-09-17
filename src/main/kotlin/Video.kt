data class Video(
    val id : Int, //	Идентификатор видеозаписи
    val owneId : Int, // Идентификатор владельца видеозаписи
    val title : String, // Название видеозаписи
    val description : String, // Текст описания видеозаписи
    val duration : Int,
    val date : Int, // Дата создания видеозаписи в формате Unixtime
    val adding_date : Int, // Дата добавления видеозаписи пользователем или группой в формате Unixtime.
    val views : Int, //	Количество просмотров видеозаписи
    val localViews : Int, // Если видео внешнее, количество просмотров в ВК
    val comments : Int
)
