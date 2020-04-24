import { IUser } from 'app/core/user/user.model';
import { Roles } from 'app/shared/model/enumerations/roles.model';

export interface IRole {
  id?: number;
  type?: Roles;
  user?: IUser;
}

export class Role implements IRole {
  constructor(public id?: number, public type?: Roles, public user?: IUser) {}
}
