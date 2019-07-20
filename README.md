[![](https://jitpack.io/v/ankit1057/SplitProgressBar.svg)](https://jitpack.io/#ankit1057/SplitProgressBar)
# Split ProgressBar For Android

Split ProgressBar For Android is a library for Showing Progress In a much easier and Beautiful Way.

## Installation


Add it in your root build.gradle at the end of repositories:
```gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

#### Fetch Using Gradle :

```gradle

dependencies {
	        implementation 'com.github.ankit1057:SplitProgressBar:Tag'
	}
```

## Usage

```java
SplitProgressDialog progressDialog = new SplitProgressDialog(MainActivity.this);
                progressDialog.setCancelable(true);
                progressDialog.setTitle(R.string.app_name);
                progressDialog.resizeDialog(500, 500);
                Drawable drawable = new ColorDrawable(Color.BLACK);
                progressDialog.setBackgroundColor(drawable);
                progressDialog.show();

```
### For Updating Progress:
```java
  progressDialog.setProgress(progress);
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

