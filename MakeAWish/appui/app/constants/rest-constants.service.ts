import { Injectable } from '@angular/core';

@Injectable()
export class RestConstantsService {
  public restConst = {
   
    'ORIGIN_URL': 'https://localhost:8443',
    'SEARCH' : '/wishlist/search',
    'ADD' : '/wishlist/add',
    'REMOVE' : '/wishlist/remove',
    'GET': '/wishlist/getAll',
    'REMOVE_ALL':'/wishlist/removeAll'
    
  }
  constructor() { }
 }
