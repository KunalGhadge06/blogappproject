import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CommentService } from 'src/app/service/comment.service';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-admin-actions',
  templateUrl: './admin-actions.component.html',
  styleUrls: ['./admin-actions.component.css']
})
export class AdminActionsComponent {
  postedBy: string | null = null;

  constructor(
    private commentService: CommentService,
    private postService: PostService,
    private snackBar: MatSnackBar
  ) {}

  deletePostsByPostedBy() {
    if (this.postedBy === null || this.postedBy.trim() === '') {
      this.snackBar.open('Please enter a valid username', 'Close', {
        duration: 3000,
      });
      return;
    }
    this.postService.deletePostByPostedBy(this.postedBy).subscribe(
      () => {
        this.snackBar.open('Posts deleted successfully', 'Close', {
          duration: 3000,
        });
      },
      error => {
        this.snackBar.open('Failed to delete posts', 'Close', {
          duration: 3000,
        });
      }
    );
  }

  deleteCommentsByPostedBy() {
    if (this.postedBy === null || this.postedBy.trim() === '') {
      this.snackBar.open('Please enter a valid username', 'Close', {
        duration: 3000,
      });
      return;
    }
    this.commentService.deleteCommentByPostedBy(this.postedBy).subscribe(
      () => {
        this.snackBar.open('Comments deleted successfully', 'Close', {
          duration: 3000,
        });
      },
      error => {
        this.snackBar.open('Failed to delete comments', 'Close', {
          duration: 3000,
        });
      }
    );
  }
}





