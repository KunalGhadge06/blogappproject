import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AngularMaterialModules } from './AngularMaterialModule';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { CreatePostComponent } from './pages/create-post/create-post.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ViewAllComponent } from './pages/view-all/view-all.component';
import { ViewPostComponent } from './pages/view-post/view-post.component';
import { SearchByNameComponent } from './pages/search-by-name/search-by-name.component';
import { AdminLoginComponent } from './pages/admin-login/admin-login.component';
import { AdminActionsComponent } from './pages/admin-actions/admin-actions.component';





@NgModule({
  declarations: [
    AppComponent,
    CreatePostComponent,
    ViewAllComponent,
    ViewPostComponent,
    SearchByNameComponent,
    AdminLoginComponent,
    AdminActionsComponent,
    
  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AngularMaterialModules,
    BrowserAnimationsModule,ReactiveFormsModule,
    HttpClientModule,
    MatInputModule,
    MatFormFieldModule
  
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
