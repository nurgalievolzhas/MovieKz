package com.snakes.moviekz

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("page") val page:Int?,
    @SerializedName("results") val movie: List<Movie>?,
    @SerializedName("total_pages") val total_pages:Int?,
    @SerializedName("total_results") val total_results:Int?
): Parcelable


@Parcelize
data class Movie(
    @SerializedName("adult") val adult:Boolean?,
    @SerializedName("backdrop_path") val backdrop_path:String?,
    @SerializedName("genres_ids") val genres_ids:List<Int>?,
    @SerializedName("id") val id:Int?,
    @SerializedName("original_language") val original_language:String?,
    @SerializedName("original_title") val original_title:String?,
    @SerializedName("overview") val overview:String?,
    @SerializedName("popularity") val popularity:Double?,
    @SerializedName("poster_path") val poster_path:String?,
    @SerializedName("release_date") val release_date:String?,
    @SerializedName("title") val title:String?,
    @SerializedName("video") val video:Boolean?,
    @SerializedName("vote_average") val vote_average:Double?,
    @SerializedName("vote_count") val vote_count:Int?,
): Parcelable


/**
 * Чаще всего при передаче объектов-сущностей от одной активности — другой, мы используем один из двух способов:
Serializable
Parcelable
 * */

/**
 * Parcelable. Он явно описывает процесс сериализации без использования рефлексии.
 * В добавок было проведено немало оптимизаций кода, чтобы повысить производительность.
 * Всё прекрасно, но у нас появляется большое количество boilerplate кода. Как можно этого избежать при написании приложения на Kotlin?
 * */

/**
 * Данная аннотация позволяет расширению генерировать логику сереализации/десериализации для полей класса.
 * В результате, методы writeToParcel() и createFromParcel() будут сгенерированы автоматически.
 * Рассмотрим два примера. Класс-сущность на Kotlin с использованием аннотации Parcelize и без.
 * */