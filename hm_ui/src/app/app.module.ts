import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AuthGuard } from './auth/auth.guard';
import { ApiProvider } from './provider/api';
import { UserProvider } from './provider/user'

import { AppComponent } from './app.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import { HomeComponent } from './view/home/home.component';
import { SignInComponent } from './view/sign-in/sign-in.component';;
import { BookComponent } from './view/book/book.component';
import { PayComponent } from './view/pay/pay.component';
import { RoomProvider } from './provider/room';
import { RHProvider } from './provider/room-history.';
import { TimerComponent } from './view/shared/timer/timer.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    HomeComponent,
    SignInComponent,
    BookComponent,
    PayComponent,
    TimerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AuthGuard, ApiProvider, UserProvider, RoomProvider, RHProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
