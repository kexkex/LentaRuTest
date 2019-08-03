package ru.tomindapps.lentarutest.models

data class NewsApiClass(
    val type: String,
    val info: Info,
    val links: Links,
    val rubric: Rubric,
    val tags: ArrayList<Tags>,
    val title_image: TitleImage
){
    class Info(
        val id: String,
        val title: String,
        val rightcol: String,
        val modified: Long
    )

    class Links(
        val self: String,
        val public: String
    )

    class Rubric(
        val slug: String,
        val title: String
    )

    class Tags(
        val title: String,
        val slug: String
    )

    class TitleImage(
        val caption: String,
        val credits: String,
        val url: String
    )
}