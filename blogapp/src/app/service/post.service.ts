import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../pages/user';

const BASIC_URL = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  deletePostByPostedBy(postedBy: string): Observable<any> {
    return this.http.delete(`${BASIC_URL}api/posts/byPostedBy/${postedBy}`);
  }

  createNewPost(data: any): Observable<any> {
    return this.http.post(BASIC_URL + 'api/posts', data);
  }

  getAllPosts(): Observable<any> {
    return this.http.get(BASIC_URL + 'api/posts');
  }

  getPostById(postId: number): Observable<any> {
    return this.http.get(`${BASIC_URL}api/posts/${postId}`);
  }

  likePost(postId: number): Observable<any> {
    return this.http.put(`${BASIC_URL}api/posts/${postId}/like`, {});
  }

  searchByName(name: string): Observable<any> {
    return this.http.get(`${BASIC_URL}api/posts/search/${name}`);
  }

  deletePost(postId: number): Observable<any> {
    return this.http.delete(`${BASIC_URL}api/posts/${postId}`);
  }

  loginAdmin(user: User): Observable<Object> {
    console.log('Sending login request:', user);
    return this.http.post(BASIC_URL + 'admin/login', user);
  }
}





