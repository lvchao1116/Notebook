package application.view;

import java.util.Arrays;

import application.dialog.LayoutInflater;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainView implements View {
	private final ImageView rootIcon = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/blue/tree_root.png")));
	private final ImageView oneIcon = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/blue/tree_article.png")));
	private final ImageView twoIcon = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/blue/tree_category.png")));
	private final ImageView threeIcon = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/blue/tree_setting.png")));

	@Override
	public Parent getView() {
			Parent parent = LayoutInflater.inflate("activity_main", Parent.class);
			parent.getStylesheets().add("css/main.css");

			AnchorPane main_left = (AnchorPane) parent.lookup("#main_left");
			AnchorPane main_center = (AnchorPane) parent.lookup("#main_center");

			// left
			TreeView treeView = new TreeView();
			// TreeView������Ҳ�Ƿ�Node���ͣ����Բ�����SceneBuilder��ͼ��
		    TreeItem<String> treeItemRoot = new TreeItem<String>("�����˵�",rootIcon);
		    treeItemRoot.getChildren().addAll(Arrays.asList(
		    		new TreeItem<String>("���¹���",oneIcon),
		    		new TreeItem<String>("������",twoIcon),
		    		new TreeItem<String>("ϵͳ����",threeIcon)
		    		));

		    treeItemRoot.getChildren().get(2).getChildren().addAll(Arrays.asList(
	                new TreeItem<String>("xx"),
	                new TreeItem<String>("xx"),
	                new TreeItem<String>("�˳�")
	                ));

		    treeItemRoot.setExpanded(true);

	        treeView.setShowRoot(true);
	        treeView.setRoot(treeItemRoot);

	        main_left.getChildren().add(treeView);

			// right
	        HBox lb_center = LayoutInflater.inflate("include_center", HBox.class);
	        main_center.getChildren().add(lb_center);
	        return parent;
	}

}