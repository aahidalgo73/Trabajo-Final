import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Contact} from './contact/contact'

export const routes: Routes = [
    {
        path:"",
        component: Home,
        title: "Página Principal"
    },
    {
        path:"contacto",
        component: Contact,
        title:"Contacto"
    }
];
