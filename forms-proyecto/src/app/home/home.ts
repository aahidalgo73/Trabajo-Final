import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ForumsService } from '../forums.service';
import { User } from '../app'; // Asegúrate que la interfaz esté definida aquí

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home implements OnInit {

  constructor(private forumService: ForumsService) {}

  user: User = { id: 0, name: '', address: '', phone: '' };
  users: User[] = [];

  ngOnInit() {
    this.getUsers();
  }

  onSubmit(user: User) {
    if (user.id) {
      this.forumService.updateUser(user).subscribe(() => {
        this.getUsers();
        this.resetForm();
      });
    } else {
      this.forumService.addUser(user).subscribe(() => {
        this.getUsers();
        this.resetForm();
      });
    }
  }

  getUsers() {
    this.forumService.getUsers().subscribe(data => {
      console.log("Datos obtenidos:", data); 
      this.users = data;
    });
  }

  editUser(user: User) {
    this.user = { ...user };
  }

  confirmDelete(user: User) {
    if (confirm(`¿Deseas eliminar a ${user.name}?`)) {
      this.forumService.deleteUser(user.id).subscribe(() => {
        this.getUsers();
      });
    }
  }

  resetForm() {
    this.user = { id: 0, name: '', address: '', phone: '' };
  }
}
