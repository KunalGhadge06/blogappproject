import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL='http://localhost:8080/';
@Injectable({
  providedIn: 'root'
})
export class CommentService {
  

  constructor(private httpclient:HttpClient) { }

  createComment(postId:number, postedBy: string, content:string) :Observable<any>{
  
    const params={
       postId: postId,
       postedBy: postedBy

    }
    return this.httpclient.post<any>(BASIC_URL+'api/comments/create',content,{params});
  }

  deleteCommentByPostedBy(postedBy: string): Observable<any> {
    return this.httpclient.delete(`${BASIC_URL}api/comments/byPostedBy/${postedBy}`);
  }

  getAllCommentsByPost(postId:number):Observable<any>
  {
    return this.httpclient.get(BASIC_URL+ `api/comments/${postId}`);
  }
  
  deleteComment(commentId: number): Observable<any> {
    return this.httpclient.delete(`${BASIC_URL}api/comments/${commentId}`);
  }
}
