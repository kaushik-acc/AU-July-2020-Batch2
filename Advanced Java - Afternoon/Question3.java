import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class Question3
{
    public static void main(String[] args) throws IOException
    {
        ProductFactory productFactory=new ProductFactory();
        List<Product> products=productFactory.getListOfProducts(25);
        int x=500;
        int y=900;

        //To get the list of products whose price range is between x and y.
        List<Product> productsFiltered =products.stream().filter(product->product.getPrice()>=x && product.getPrice()<=y).collect(Collectors.toList());
        System.out.println("Filtered products :");
        productsFiltered.forEach(product->System.out.println(product.getName()));

        //To get the total categories in the product list.
        Set<Integer> categories=products.stream().map(Product::getCategory).collect(Collectors.toSet());
        int totalCategories=categories.size();
        System.out.println("Total no. of categories = "+totalCategories);

        //To get the maximum and minimum priced product in each category.
        for(Integer i: categories)
        {
            int max,min;
            max=products.stream().filter(product->product.getCategory()==i).map(Product::getPrice).max(Comparator.comparing(Integer::valueOf)).get();
            min=products.stream().filter(product->product.getCategory()==i).map(Product::getPrice).min(Comparator.comparing(Integer::valueOf)).get();
            System.out.println("Max price in category "+i+" = "+max);
            System.out.println("Min price in category "+i+" = "+min);

        }
    }

}
class ProductFactory {

    public List<Product> getListOfProducts(int numOfProducts) {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= numOfProducts; i++) {
            products.add(createProduct(i));
        }
        return products;
    }

    private Product createProduct(int i) {
        Product product = new Product();
        product.setName("Product " + i);
        product.setCategory((int) (Math.random() * (10-1+1) + 1));
        product.setPrice((int) (Math.random() * (1000 - 100 + 1) + 100));
        return product;

    }


}


class Product {
    private String name;
    private Integer category;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category=category;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price=price;
    }
}