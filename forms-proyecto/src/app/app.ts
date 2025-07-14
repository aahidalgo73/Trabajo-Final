import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'apis';
}

export interface forumPost{
  userId: number;
  id: number;
  title: string;
  body:string;
}

export interface User{
  id: number;
  name: string;
  address: string;
  phone:string;
}