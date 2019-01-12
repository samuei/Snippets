from tinytag import TinyTag # https://github.com/devsnd/tinytag
import os

def rename_files(path_to_media):
    # replace arbitrary filenames with Artist - Song Title in specified folder
    # Example input: rename_files('C:\\Users\\doug\\Music')
    
    print('Getting list of files')
    file_list = os.listdir(path_to_media)
    
    saved_path = os.getcwd()
    print('Navigating to ' + saved_path)
    os.chdir(path_to_media)
    
    files_renamed = 0
    files_skipped = 0
    #rename each file 
    for file_name in file_list:
        oldname, extension = os.path.splitext(file_name)
        
        # ignore non-mp3 files:
        if extension == '.mp3':
            tag = TinyTag.get(file_name)
            # ignore files without the necessary metadata:
            if tag.artist is None or tag.title is None:
                files_skipped += 1
                continue
            
            # Kludgey? Yes. Deals with Simon & Garfunkel without crashing? Yes.
            # Windows also forbids some other characters. Beware.
            os.rename(file_name,
                      tag.artist.replace('/','∕').replace('\\','\\\\')
                      + ' - '
                      + tag.title.replace('/','∕').replace('\\','\\\\')
                      + '.mp3')
            files_renamed += 1
    
    # Go back to where we were:
    os.chdir(saved_path)
    
    print('Finished.')
    print(str(files_renamed)
          + ' files renamed. '
          + str(files_skipped)
          + ' skipped.')
