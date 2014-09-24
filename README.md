GridImageSearch
==============

An app which searches for images based on keywords entered by a user. Pulls data using Google APIs.

Time spent: In total, ~22 hours.

Completed user stories:

 * [x] User can enter a search query that will display a grid of image results from the Google Image API. 
 * [x] User can click on "settings" which allows selection of advanced search options to filter results
 * [x] User can configure advanced search filters such as size, color, type, and site
 * [x] Subsequent searches will have any filters applied to the search results
 * [x] User can tap on any image in results to see the image full-screen
 * [x] User can scroll down “infinitely” to continue loading more image results (up to 8 pages)
 * [x] Use the ActionBar SearchView as the query box instead of an EditText
 * [x] User can share an image to their friends or email it to themselves
 * [x] Use a lightweight modal overlay for filter selection instead of an activity

Walkthrough of all user stories:

![Video Walkthrough](GridImageSearch.gif)

GIF created with [LiceCap](http://www.cockos.com/licecap/).

Used Google's APIs to get the data, Picasso (http://square.github.io/picasso/) to download and display the images and Android Async Http Client for all Async calls to the Instagram APIs (http://loopj.com/android-async-http/).


