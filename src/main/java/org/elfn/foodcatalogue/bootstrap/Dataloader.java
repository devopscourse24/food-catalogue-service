package org.elfn.foodcatalogue.bootstrap;

import org.elfn.foodcatalogue.entities.FoodItem;
import org.elfn.foodcatalogue.repositories.FoodItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Dataloader implements CommandLineRunner {

    final FoodItemRepository foodItemRepository;

    public Dataloader(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){

        // Articles pour le restaurant Chez Antoinette
        FoodItem aloco = new FoodItem(2, "Aloco", "Bananes plantains frites servies avec une sauce tomate épicée", false, 2500L, 1152, 0);
        FoodItem attiekePoisson = new FoodItem(3, "Attieke au Poisson", "Semoule de manioc avec poisson grillé et sauce oignons", false, 4500L, 1152, 0);
        FoodItem garba = new FoodItem(4, "Garba", "Thon émincé sur de l'attiéké avec des oignons et du piment", false, 2000L, 1152, 0);
        FoodItem pouletBraise = new FoodItem(5, "Poulet Braisé", "Poulet entier mariné et grillé au charbon", false, 5500L, 1152, 0);

// Articles pour le restaurant Le Patriote
        FoodItem foutouBanane = new FoodItem(6, "Foutou Banane", "Pâte de banane plantain accompagnée de sauce graine", false, 3500L, 1153, 0);
        FoodItem soupeKandji = new FoodItem(7, "Soupe Kandji", "Soupe de poisson fumé avec légumes locaux", false, 4000L, 1153, 0);
        FoodItem attiekePoulet = new FoodItem(8, "Attieke au Poulet", "Semoule de manioc avec poulet frit et sauce oignons", false, 4500L, 1153, 0);
        FoodItem braisedFish = new FoodItem(9, "Poisson Braisé", "Poisson frais grillé avec marinade épicée", false, 5000L, 1153, 0);

// Articles pour le café De La Paix
        FoodItem croissant = new FoodItem(10, "Croissant", "Viennoiserie au beurre frais", true, 1000L, 1154, 0);
        FoodItem eclairChocolat = new FoodItem(11, "Éclair au Chocolat", "Pâtisserie au chocolat et crème pâtissière", true, 1500L, 1154, 0);
        FoodItem milleFeuille = new FoodItem(12, "Mille-Feuille", "Gâteau superposé de pâte feuilletée et de crème", true, 2000L, 1154, 0);
        FoodItem tarteTatin = new FoodItem(13, "Tarte Tatin", "Tarte aux pommes caramélisées, servie tiède", true, 2500L, 1154, 0);

// Articles pour le restaurant La Perle Noire
        FoodItem fruitsDeMer = new FoodItem(14, "Assiette de Fruits de Mer", "Sélection de fruits de mer frais du jour", false, 7500L, 1155, 0);
        FoodItem poissonYassa = new FoodItem(15, "Poisson Yassa", "Poisson mariné dans une sauce aux oignons et citron", false, 6000L, 1155, 0);
        FoodItem crevettesSauce = new FoodItem(16, "Crevettes en Sauce", "Crevettes sautées dans une sauce tomate piquante", false, 6500L, 1155, 0);
        FoodItem calamarsFrits = new FoodItem(17, "Calamars Frits", "Calamars panés et frits, servis avec une mayonnaise épicée", false, 5000L, 1155, 0);

// Articles pour le restaurant L'Épicurien
        FoodItem souffleFromage = new FoodItem(22, "Soufflé au Fromage", "Un classique de la cuisine française, ce soufflé léger est fait avec du fromage comté et emmental.", true, 6000L, 1156, 0); // Un soufflé au fromage aéré et gourmand.
        FoodItem boeufBourguignon = new FoodItem(23, "Bœuf Bourguignon", "Ragoût de bœuf mijoté pendant des heures dans une sauce au vin rouge riche en saveurs, accompagné de petits légumes.", false, 8500L, 1156, 0); // Un plat réconfortant et riche en goût.
        FoodItem coqAuVin = new FoodItem(24, "Coq au Vin", "Poulet cuit lentement dans une sauce au vin avec des lardons et champignons, un plat riche en histoire et en goût.", false, 8000L, 1156, 0); // Une recette traditionnelle française.
        FoodItem ratatouille = new FoodItem(25, "Ratatouille", "Mélange harmonieux de légumes provençaux cuits à l'étouffée, une explosion de saveurs méditerranéennes.", true, 5000L, 1156, 0); // Un accompagnement sain et savoureux.

        // Articles pour le restaurant Le Jardin Gourmand
        FoodItem saladeGourmande = new FoodItem(18, "Salade Gourmande", "Salade composée de produits du marché", true, 3000L, 1157, 0);
        FoodItem filetMignon = new FoodItem(19, "Filet Mignon", "Filet mignon de porc, sauce aux champignons", false, 8000L, 1157, 0);
        FoodItem risottoAuxChampignons = new FoodItem(20, "Risotto aux Champignons", "Risotto crémeux aux champignons sauvages", true, 7000L, 1157, 0);
        FoodItem tournedosRossini = new FoodItem(21, "Tournedos Rossini", "Médaillon de filet de bœuf poêlé, surmonté de foie gras et nappé d'une sauce au truffe", false, 9500L, 1157, 0); // Un plat de haute gastronomie, hommage au célèbre compositeur Rossini.



        // Création d'une liste de tous les FoodItem
        List<FoodItem> allFoodItems = Arrays.asList(
                aloco, attiekePoisson, garba, pouletBraise,
                foutouBanane, soupeKandji, attiekePoulet, braisedFish,
                croissant, eclairChocolat, milleFeuille, tarteTatin,
                fruitsDeMer, poissonYassa, crevettesSauce, calamarsFrits,
                souffleFromage, boeufBourguignon, coqAuVin, ratatouille,
                saladeGourmande, filetMignon, risottoAuxChampignons, tournedosRossini
        );

        // Utilisation de la méthode saveAll du repository pour enregistrer tous les FoodItem en une seule opération
        foodItemRepository.saveAll(allFoodItems);
    }
}
