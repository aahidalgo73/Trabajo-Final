import { HttpClient, HttpHeaders } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ForumsService {
  private readonly apiUrl = 'http://localhost:8080/api/users';
  private http = inject(HttpClient);
  private jsonHeaders = new HttpHeaders({ 'Content-type': 'application/json' });

  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/`, {
      headers: this.jsonHeaders
    });
  }

  addUser(user: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add`, user, {
      headers: this.jsonHeaders
    });
     this.getUsers();
  }

  updateUser(user: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update/${user.id}`, user, {
      headers: this.jsonHeaders
    });
     this.getUsers();
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, {
      headers: this.jsonHeaders
    });
     this.getUsers();
  }
}
