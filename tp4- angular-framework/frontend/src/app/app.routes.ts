import { Routes } from '@angular/router';
import { InventoryComponent } from './pages/inventory/inventory.component';

export const routes: Routes = [
  { path: '', redirectTo: 'catalog', pathMatch: 'full' },
  { path: 'catalog', component: InventoryComponent },
  { path: '**', redirectTo: 'catalog' }
];
