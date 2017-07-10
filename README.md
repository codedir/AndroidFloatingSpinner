<h1 align="center"> Android Floating Spinner </h1>

<p align="center">
  <a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#ICE_CREAM_SANDWICH"><img src="https://img.shields.io/badge/API-14%2B-blue.svg?style=flat" alt="API" /></a>
  <a target="_blank" href="LICENSE"><img src="http://img.shields.io/:license-apache-blue.svg" alt="License" /></a>
  </p>
  
 ___
 
 Usage
-----

Add the layout XML:

```xml
   <android.support.design.widget.TextInputLayout
        android:id="@+id/textInputLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp">
        
        <com.codedir.library.InputSpinner
            android:id="@+id/list"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/hint"
            android:textSize="16sp" />
    </android.support.design.widget.TextInputLayout>
```

Add the JAVA:

```java
        String str[] = {"android", "ios", "windows"};
        InputSpinner spinner = (InputSpinner) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,str);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new InputSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelectedListener(String item, int selectedIndex) {
                
            }
        });
```

License
--------

    Copyright (C) 2016 Jared Rummler

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
