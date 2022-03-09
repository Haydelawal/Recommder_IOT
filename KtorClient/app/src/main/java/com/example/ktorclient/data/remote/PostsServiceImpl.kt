package com.example.ktorclient.data.remote

import com.example.ktorclient.data.remote.dto.PostRequest
import com.example.ktorclient.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.text.get

class PostsServiceImpl (private val client: HttpClient) : PostsService {

    override suspend fun getPosts(): List<PostResponse> {

        return try {
            client.get {
                url(HttpRoutes.POSTS)

            }
        } catch (e: RedirectResponseException) {
            // 300-399 Responses
            println("Error: ${ e.response.status.description}")
            emptyList()
        }
        catch (e: ClientRequestException) {
            // 400-499 Responses
            println("Error: ${ e.response.status.description}")
            emptyList()
        }
        catch (e: ServerResponseException) {
            // 500-599 Responses
            println("Error: ${ e.response.status.description}")
            emptyList()
        }
        catch (e: Exception) {
            // 500-599 Responses
            println("Error: ${ e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {

        return try {
            client.post<PostResponse> {
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest

            }
        } catch (e: RedirectResponseException) {
            // 300-399 Responses
            println("Error: ${ e.response.status.description}")
           null
        }
        catch (e: ClientRequestException) {
            // 400-499 Responses
            println("Error: ${ e.response.status.description}")
            null
        }
        catch (e: ServerResponseException) {
            // 500-599 Responses
            println("Error: ${ e.response.status.description}")
            null
        }
        catch (e: Exception) {
            // 500-599 Responses
            println("Error: ${ e.message}")
            null
        }
    }
}