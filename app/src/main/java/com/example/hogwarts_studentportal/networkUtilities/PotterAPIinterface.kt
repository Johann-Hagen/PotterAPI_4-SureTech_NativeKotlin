package com.example.hogwarts_studentportal.networkUtilities
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.HouseList
import kotlinx.coroutines.Deferred
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.SpellList
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.StudentList
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val kAPIkey = "$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y"
interface PotterAPIinterface {
     @GET("spells")
     fun getsllSpells(): Deferred<SpellList>

     @GET("characters")
     fun getallstudents(
          @Query("role") role: String = "student"
     ): Deferred<StudentList>

     @GET("houses")
     fun getallHouses(): Deferred<HouseList>

     companion object{
          operator  fun invoke(): PotterAPIinterface{
               val requestInterceptor = Interceptor{
                    chain ->
                    val url = chain.request()
                         .url()
                         .newBuilder()
                         .addQueryParameter("key", kAPIkey)
                         .build()
                    val request = chain.request()
                         .newBuilder()
                         .url(url)
                         .build()
                    return@Interceptor chain.proceed(request)
               }
               val okHttpClient =  OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .build()

               return  Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://www.potterapi.com/v1/")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PotterAPIinterface::class.java)
          }
     }
}




