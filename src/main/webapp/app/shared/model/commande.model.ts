import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';
import { IRestaurant } from 'app/shared/model/restaurant.model';
import { IPanier } from 'app/shared/model/panier.model';
import { IPaiement } from 'app/shared/model/paiement.model';

export interface ICommande {
  id?: number;
  echeance?: Moment;
  user?: IUser;
  restaurant?: IRestaurant;
  panier?: IPanier;
  paiement?: IPaiement;
}

export class Commande implements ICommande {
  constructor(
    public id?: number,
    public echeance?: Moment,
    public user?: IUser,
    public restaurant?: IRestaurant,
    public panier?: IPanier,
    public paiement?: IPaiement
  ) {}
}
