import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import { HomeComponent } from './view/home/home.component';
import { AuthGuard } from './auth/auth.guard';
import { SignInComponent } from './view/sign-in/sign-in.component';
import { BookComponent } from './view/book/book.component';
import { PayComponent } from './view/pay/pay.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home', component: HomeComponent,
    children: [
      { path: '', component: DashboardComponent },
      { path: 'dashboard', component: DashboardComponent },
      { path: 'book/:id', component: BookComponent },
      { path: 'pay', component: PayComponent },
    ]
  },
  { path: 'sign-in', component: SignInComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
