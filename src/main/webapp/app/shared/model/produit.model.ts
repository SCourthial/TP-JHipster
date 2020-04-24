import { IRestaurant } from 'app/shared/model/restaurant.model';
import { IPanier } from 'app/shared/model/panier.model';

export interface IProduit {
  id?: number;
  nom?: string;
  prix?: number;
  dispo?: number;
  restaurant?: IRestaurant;
  paniers?: IPanier[];
}

export class Produit implements IProduit {
  constructor(
    public id?: number,
    public nom?: string,
    public prix?: number,
    public dispo?: number,
    public restaurant?: IRestaurant,
    public paniers?: IPanier[]
  ) {}
}
