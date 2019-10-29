package pl.mojefilmy.FilmsFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.mojefilmy.database.dao.CategoryDao;
import pl.mojefilmy.database.dbutils.DbManager;
import pl.mojefilmy.database.models.Category;
import pl.mojefilmy.utils.exceptions.ApplicationException;

import java.util.List;

public class CategoryModel {

    private ObservableList<CategoryFx> categoryList = FXCollections.observableArrayList();
    private ObjectProperty<CategoryFx> category = new SimpleObjectProperty<>();

    public void init(){
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        List<Category> categories = null;
        this.categoryList.clear();
        try {
            categories = categoryDao.queryForAll(Category.class);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        categories.forEach(c->{
           CategoryFx categoryFx = new CategoryFx();
           categoryFx.setName(c.getName());
           categoryFx.setId(c.getId());
           this.categoryList.add(categoryFx);
        });
        DbManager.closeConnectionSource();
    }

    public void deleteCategoryById(){
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        try {
            categoryDao.deleteById(Category.class, category.getValue().getId());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();
        init();
    }

    public void saveCategoryInDataBase(String name){
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        Category category = new Category();
        category.setName(name);
        try {
            categoryDao.creatOrUpdate(category);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();
        init();

    }

    public ObservableList<CategoryFx> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ObservableList<CategoryFx> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryFx getCategory() {
        return category.get();
    }

    public ObjectProperty<CategoryFx> categoryProperty() {
        return category;
    }

    public void setCategory(CategoryFx category) {
        this.category.set(category);
    }


}
