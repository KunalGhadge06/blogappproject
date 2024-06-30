import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePostComponent } from './pages/create-post/create-post.component';
import { ViewAllComponent } from './pages/view-all/view-all.component';
import { ViewPostComponent } from './pages/view-post/view-post.component';
import { SearchByNameComponent } from './pages/search-by-name/search-by-name.component';
import { AdminActionsComponent } from './pages/admin-actions/admin-actions.component';
import { AdminLoginComponent } from './pages/admin-login/admin-login.component';

const routes: Routes = [
  {path:'create-post',component:CreatePostComponent},
  {path:'view-all',component:ViewAllComponent},
  {path:'view-post/:id',component:ViewPostComponent},
  {path:'search-by-name',component:SearchByNameComponent},
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'admin-actions', component: AdminActionsComponent },
  { path: '', redirectTo: '/admin-login', pathMatch: 'full' } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
