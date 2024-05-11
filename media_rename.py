from tinytag import TinyTag # https://github.com/devsnd/tinytag
import os

def get_sanitized_string(original_string):
    # Please note: This is not comprehensive
    return original_string \
           .replace('/', '∕') \
           .replace('\\', '\\\\') \
           .replace('?', '？') \
           .replace('*', '⁎') \
           .replace(':', '꞉') \
           .replace('<', '＜') \
           .replace('>', '＞') \
           .replace('"', '″') \
           .strip()

def rename_files(path_to_media):
    # Replace arbitrary filenames with Artist - Song Title in specified folder
    # Example input: rename_files('C:\\Users\\doug\\Music')
    
    saved_path = os.getcwd()
    print('Beginning from ' + saved_path)
    
    print('Getting list of files')
    file_list = os.listdir(path_to_media)
    
    print('Navigating to ' + path_to_media)
    os.chdir(path_to_media)
    
    files_renamed = 0
    files_skipped = 0
    # Rename each file 
    for file_name in file_list:
        oldname, extension = os.path.splitext(file_name)
        
        # Ignore non-mp3 files:
        if extension == '.mp3' or extension == '.m4a':
            tag = TinyTag.get(file_name)
            # Ignore files without the necessary metadata:
            if (tag.artist is None and tag.albumartist is None) or tag.title is None:
                files_skipped += 1
                continue
            
            if tag.artist is None:
                artist_name = tag.albumartist
            else:
                artist_name = tag.artist

            artist_name = get_sanitized_string(artist_name)
            new_title = get_sanitized_string(tag.title)
            
            os.rename(file_name,
                      artist_name
                      + ' - '
                      + new_title
                      + extension)
            files_renamed += 1
    
    # Go back to where we were:
    os.chdir(saved_path)
    
    print('Finished.')
    print(str(files_renamed)
          + ' files renamed. '
          + str(files_skipped)
          + ' skipped.')
