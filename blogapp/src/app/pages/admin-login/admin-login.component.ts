import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { PostService } from 'src/app/service/post.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
  user: User = new User();
  errorMessage: string = '';
  isSubmitting: boolean = false;

  constructor(
    private router: Router,
    private postService: PostService,
    private snackBar: MatSnackBar
  ) {}

  login() {
    if (this.isSubmitting) return;

    this.isSubmitting = true;
    this.postService.loginAdmin(this.user).subscribe(
      data => {
        console.log('Login Successful', data);
        this.snackBar.open('Login Successfully', 'Close', {
          duration: 3000,
        });
        this.router.navigate(['/admin-actions']);
        this.isSubmitting = false;
      },
      error => {
        console.error('Login Failed', error); // Log the error
        this.errorMessage = 'Please enter correct User ID and Password';
        this.snackBar.open(this.errorMessage, 'Close', {
          duration: 3000,
        });
        this.isSubmitting = false;
      }
    );
  }
}
