import { Suggestion } from "./suggestion";
import { SuggestionsGroup } from "./suggestion-group";
import { Product } from "./product";


export class SearchData {

    suggestions: Suggestion[];
    suggestionsGroups: SuggestionsGroup[];
    categories: string[];
    products: Product[];

}